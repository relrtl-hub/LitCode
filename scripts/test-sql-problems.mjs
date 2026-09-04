import assert from 'node:assert/strict';
import fs from 'node:fs';
import test from 'node:test';

const sourcePath = 'src/main/resources/data/problems.json';
const docsPath = 'docs/data/problems.json';
const sourceProblems = JSON.parse(fs.readFileSync(sourcePath, 'utf8'));
const docsProblems = JSON.parse(fs.readFileSync(docsPath, 'utf8'));
const expected = {
  'sql-basic-sum': {
    name: 'SQL Basic Sum',
    difficulty: 'Easy',
    category: 'Database & SQL',
    language: 'SQL',
    source: 'Coderbyte',
  },
  'sql-contains-letter': {
    name: 'SQL Contains Letter',
    difficulty: 'Medium',
    category: 'Database & SQL',
    language: 'SQL',
    source: 'Coderbyte',
  },
  'sql-member-count': {
    name: 'SQL Member Count',
    difficulty: 'Medium',
    category: 'Database & SQL',
    language: 'SQL',
    source: 'Coderbyte',
  },
};

test('catalog contains the three SQL practice entries with explicit metadata', () => {
  for (const [id, fields] of Object.entries(expected)) {
    const problem = sourceProblems.find((entry) => entry.id === id);
    assert.ok(problem, `missing catalog entry: ${id}`);
    for (const [field, value] of Object.entries(fields)) {
      assert.equal(problem[field], value, `${id}.${field}`);
    }
    assert.equal(problem.number, null, `${id}.number should be null`);
    assert.match(problem.solutionCode, /\bSELECT\b/i, `${id} should contain a SQL query`);
    assert.doesNotMatch(problem.solutionCode, /class\s+Solution|public\s+(?:static\s+)?(?:class|void|int|String)/, `${id} must not contain Java code`);
    assert.ok(problem.schema, `${id} should document its schema assumptions`);
    assert.ok(problem.tags?.includes('SQL'), `${id} should be tagged SQL`);
  }
});

test('deployed catalog data matches the source catalog data', () => {
  assert.deepEqual(docsProblems, sourceProblems);
});

test('frontend copies expose SQL metadata rendering hooks', () => {
  for (const file of ['src/main/resources/static/index.html', 'docs/index.html']) {
    const html = fs.readFileSync(file, 'utf8');
    assert.match(html, /p\.language/);
    assert.match(html, /p\.category/);
    assert.match(html, /p\.source/);
    assert.match(html, /p\.language === 'SQL'/);
  }
});

test('SQL queries are stored and rendered as readable multiline code', () => {
  for (const problem of sourceProblems.filter((entry) => entry.language === 'SQL')) {
    assert.ok(problem.solutionCode.includes('\n'), `${problem.id} should contain line breaks`);
    assert.match(problem.solutionCode, /\n(?:FROM|JOIN|LEFT JOIN|WHERE|GROUP BY|ORDER BY)\b/i, `${problem.id} should break SQL clauses onto separate lines`);
  }

  for (const file of ['src/main/resources/static/index.html', 'docs/index.html']) {
    const html = fs.readFileSync(file, 'utf8');
    assert.match(html, /function formatSqlQuery\(query\)/, `${file} should expose SQL query formatting`);
    assert.match(html, /formatSqlQuery\(p\.solutionCode\)/, `${file} should use SQL query formatting`);
  }
});

test('Java list endpoint exposes nullable-safe SQL summary metadata', () => {
  const source = fs.readFileSync('src/main/java/com/litcode/server/WebServer.java', 'utf8');
  assert.match(source, /new LinkedHashMap/);
  assert.match(source, /summary\.put\("language", p\.getLanguage\(\)\)/);
  assert.match(source, /summary\.put\("category", p\.getCategory\(\)\)/);
  assert.match(source, /summary\.put\("source", p\.getSource\(\)\)/);
});
