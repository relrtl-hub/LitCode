import assert from 'node:assert/strict';
import fs from 'node:fs';
import test from 'node:test';

const source = JSON.parse(fs.readFileSync('src/main/resources/data/problems.json', 'utf8'));
const deployed = JSON.parse(fs.readFileSync('docs/data/problems.json', 'utf8'));
const byId = new Map(source.map((problem) => [problem.id, problem]));

const neetCodeCategories = [
  'Arrays & Hashing',
  'Two Pointers',
  'Binary Search',
  'Stack',
  'Sliding Window',
  'Linked List',
  'Trees',
  'Tries',
  'Heap / Priority Queue',
  'Backtracking',
  'Graphs',
  '1-D Dynamic Programming',
  'Intervals',
  'Greedy',
  'Advanced Graphs',
  'Math & Geometry',
  '2-D Dynamic Programming',
  'Bit Manipulation',
  'Database & SQL',
];

const javaIds = [
  'find-intersection', 'nonrepeating-character', 'array-addition-i', 'longest-word',
  'bracket-matcher', 'min-window-substring', 'tree-constructor', 'questions-marks',
  'reverse-polish-notation', 'max-heap-checker', 'lcs', 'maximal-rectangle',
  'farthest-nodes', 'hamiltonian-path',
];

const hardSqlIds = [
  'sql-employee-salaries',
  'sql-employees-more-than-managers',
  'sql-department-top-salaries',
  'sql-parent-child-rollup',
];

test('catalog includes every remaining Java challenge exactly once', () => {
  for (const id of javaIds) {
    const problem = byId.get(id);
    assert.ok(problem, `missing Java entry: ${id}`);
    assert.equal(problem.language, 'Java', `${id}.language`);
    assert.equal(problem.source, 'Coderbyte', `${id}.source`);
    assert.ok(neetCodeCategories.includes(problem.category), `${id}.category`);
    assert.ok(problem.tags?.length > 0, `${id}.tags`);
    assert.match(problem.solutionCode, /class\s+Solution|public\s+(?:static\s+)?(?:boolean|int|long|String|void|List|Map)/, `${id} should contain Java code`);
  }
  assert.equal(new Set(javaIds).size, javaIds.length);
});

test('every existing and new problem has a primary category and language', () => {
  for (const problem of source) {
    assert.ok(problem.language, `${problem.id}.language`);
    assert.ok(neetCodeCategories.includes(problem.category), `${problem.id}.category`);
    assert.ok(Array.isArray(problem.tags) && problem.tags.length > 0, `${problem.id}.tags`);
  }
});

test('catalog includes harder SQL patterns requested by the user', () => {
  for (const id of hardSqlIds) {
    const problem = byId.get(id);
    assert.ok(problem, `missing hard SQL entry: ${id}`);
    assert.equal(problem.language, 'SQL');
    assert.equal(problem.difficulty, 'Hard');
    assert.equal(problem.category, 'Database & SQL');
    assert.equal(problem.number, null);
    assert.ok(problem.schema, `${id}.schema`);
    assert.match(problem.solutionCode, /\bJOIN\b/i, `${id} should use a table join`);
    assert.match(problem.solutionCode, /\bSELECT\b[\s\S]*\bSELECT\b/i, `${id} should use a nested query`);
    assert.match(problem.solutionCode, /\b(?:employee|employees|category|categories|maintable_XXXX)\b\s+(?:AS\s+)?(?:e|m|child|parent|c1|c2)/i, `${id} should show multiple aliases of a related table`);
  }
});

test('source and deployed catalogs stay identical', () => {
  assert.deepEqual(deployed, source);
});

test('frontend exposes category filtering and category metadata', () => {
  for (const file of ['src/main/resources/static/index.html', 'docs/index.html']) {
    const html = fs.readFileSync(file, 'utf8');
    assert.match(html, /category-filter/);
    assert.match(html, /categoryFilter/);
    assert.match(html, /problem\.category/);
    assert.match(html, /categoryCounts/);
  }
});

test('new string solutions are stored as readable multiline code', () => {
  for (const id of ['find-intersection', 'nonrepeating-character']) {
    const problem = byId.get(id);
    assert.ok(problem, `missing ${id}`);
    assert.ok(problem.solutionCode.includes('\n'), `${id} should contain line breaks`);
  }
});
