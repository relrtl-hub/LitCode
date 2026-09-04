import assert from 'node:assert/strict';
import fs from 'node:fs';

const files = [
  'src/main/resources/static/index.html',
  'docs/index.html',
];

for (const file of files) {
  const html = fs.readFileSync(file, 'utf8');

  assert.match(html, /id="open-problems"/, `${file}: missing mobile Problems control`);
  assert.match(html, /id="close-problems"/, `${file}: missing mobile close control`);
  assert.match(html, /aria-controls="problem-sidebar"/, `${file}: missing sidebar relationship`);
  assert.match(html, /\.sidebar-hidden \.sidebar\s*\{/, `${file}: missing hidden drawer state`);
  assert.match(html, /function setProblemListOpen\(open\)/, `${file}: missing drawer state function`);
  assert.match(html, /setProblemListOpen\(false\)/, `${file}: selecting a problem must close the drawer`);
  assert.match(html, /matchMedia\('\(max-width: 760px\)'\)/, `${file}: missing responsive breakpoint state`);
}

console.log('Mobile layout contract passed for both frontend copies.');
