function wordPattern(pattern: string, s: string) {
  const words = s.split(' ');
  if (pattern.length !== words.length) return false;

  const charToWord = new Map<string, string>();
  const wordToChar = new Map<string, string>();

  for (let i = 0; i < pattern.length; i++) {
    const ch = pattern.charAt(i);
    const word = words[i];

    if (charToWord.has(ch) && charToWord.get(ch) !== word) {
      return false;
    }

    if (wordToChar.has(word) && wordToChar.get(word) !== ch) {
      return false;
    }

    charToWord.set(ch, word);
    wordToChar.set(word, ch);
  }

  return true;
}
console.log(wordPattern('abba', 'dog cat cat dog'));
