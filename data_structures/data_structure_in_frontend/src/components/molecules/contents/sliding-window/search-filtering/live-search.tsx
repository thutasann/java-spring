'use client'
import { Input } from '@/components/ui/input'
import { products } from '@/lib/data_structure/sliding_window/products'
import React, { useState } from 'react'

function highlightMatch(text: string, query: string) {
  if (!query) return text
  const regex = new RegExp(`(${query})`, 'gi')
  return text.split(regex).map((part, index) => {
    return part.toLowerCase() === query.toLowerCase() ? (
      <span key={index} className='rounded-sm bg-primary px-1'>
        {part}
      </span>
    ) : (
      part
    )
  })
}

function LiveSearch() {
  const [query, setQuery] = useState('')
  const [results, setResults] = useState<string[]>(products)

  const handleSearch = (e: React.ChangeEvent<HTMLInputElement>) => {
    const value = e.target.value
    setQuery(value)
    if (!value) return setResults(products)

    let end = 0,
      windowSize = 10
    const filtered = []

    while (end < products.length) {
      if (products[end].toLowerCase().includes(value.toLowerCase())) {
        filtered.push(products[end])
        if (filtered.length >= windowSize) break
      }
      end++
    }

    setResults(filtered)
  }

  return (
    <>
      <Input type='text' placeholder='Search products...' value={query} onChange={handleSearch} />
      <p className='my-2 text-sm text-secondary-foreground'>Search Result : {results.length || 0}</p>
      <ul className='mt-4 divide-y rounded border'>
        {results.map((product, index) => (
          <li key={index} className='p-2'>
            {highlightMatch(product, query)}
          </li>
        ))}
      </ul>
    </>
  )
}

export default LiveSearch
