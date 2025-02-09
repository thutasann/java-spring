'use client'

import { Input } from '@/components/ui/input'
import { largeText } from '@/lib/data_structure/sliding_window/large_text'
import React, { useEffect, useState } from 'react'

/**
 * Find SubString Utility
 * @description This function uses a simple sliding window approach to find all occurrences of a given substring (pattern) within a larger string (text). It slides a window of size m (length of the pattern) over the text and checks if the window matches the pattern.
 * @link [More Optimized -> KMP Algorithm](https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/)
 * @param text - Large Text
 * @param pattern - Pattern
 */
function findSubstrings(text: string, pattern: string): number[] {
  const results: number[] = []
  const patternLength = pattern.length
  const textLength = text.length

  for (let i = 0; i < textLength; i++) {
    let window = text.substring(i, i + patternLength)
    if (window === pattern) {
      results.push(i)
    }
  }

  return results
}

/**
 * Hightlight matches utility
 */
function highlightMatches(text: string, pattern: string, occurrences: number[]) {
  if (!pattern || occurrences.length === 0) return text

  let lastIndex = 0
  const highlightedText: (string | JSX.Element)[] = []

  occurrences.forEach((index, i) => {
    if (i > 0 && occurrences[i - 1] + pattern.length > index) return

    highlightedText.push(text.slice(lastIndex, index))
    highlightedText.push(
      <span key={index} className='bg-primary'>
        {text.slice(index, index + pattern.length)}
      </span>,
    )
    lastIndex = index + pattern.length
  })

  highlightedText.push(text.slice(lastIndex))
  return highlightedText
}

function SubStringSearch() {
  const [pattern, setPattern] = useState('xyz')
  const [occurrences, setOccurrences] = useState<number[]>([])

  useEffect(() => {
    const results = findSubstrings(largeText, pattern)
    setOccurrences(results)
  }, [pattern])

  return (
    <div>
      <Input
        type='text'
        value={pattern}
        onChange={(e) => setPattern(e.target.value)}
        placeholder='Enter substring to find...'
        className='mb-4 w-full border p-2'
      />

      <div className='my-3 rounded-md border p-3'>
        <p className='text-sm'>{highlightMatches(largeText, pattern, occurrences)}</p>
      </div>

      <div>
        <p className='mb-3'>Occurrences of "{pattern}":</p>
        <ul className='h-[300px] overflow-y-auto'>
          {occurrences.map((index) => (
            <li key={index}>Found at index: {index}</li>
          ))}
        </ul>
      </div>
    </div>
  )
}

export default SubStringSearch
