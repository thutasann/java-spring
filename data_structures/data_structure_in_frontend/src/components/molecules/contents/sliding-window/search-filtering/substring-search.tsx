'use client'

import { Input } from '@/components/ui/input'
import { largeText } from '@/lib/data_structure/sliding_window/large_text'
import React, { useEffect, useState } from 'react'

/**
 * Find SubString Utility
 * @description This function uses a simple sliding window approach to find all occurrences of a given substring (pattern) within a larger string (text). It slides a window of size m (length of the pattern) over the text and checks if the window matches the pattern.
 * @link (https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/)[https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/]
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

function SubStringSearch() {
  const [pattern, setPattern] = useState('xyz')
  const [occurrences, setOccurrences] = useState<number[]>([])

  useEffect(() => {
    const results = findSubstrings(largeText, pattern)
    setOccurrences(results)
  }, [pattern])

  return (
    <div className='p-4'>
      <Input
        type='text'
        value={pattern}
        onChange={(e) => setPattern(e.target.value)}
        placeholder='Enter substring to find...'
        className='mb-4 w-full border p-2'
      />
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
