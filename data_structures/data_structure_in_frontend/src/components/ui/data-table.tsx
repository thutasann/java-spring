'use client'

import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from '@/components/ui/table'
import { cn } from '@/lib/utils'
import {
  ColumnDef,
  flexRender,
  getCoreRowModel,
  getFilteredRowModel,
  getPaginationRowModel,
  getSortedRowModel,
  useReactTable,
} from '@tanstack/react-table'
import { RefreshCcw } from 'lucide-react'
import CustomTooltip from '../atoms/custom-tooltip'
import { DataTablePagination } from '../molecules/data-table/pagination'
import { DataTableViewOptions } from '../molecules/data-table/view-options'
import { Button } from './button'
import { Input } from './input'
import { ScrollArea, ScrollBar } from './scroll-area'

interface DataTableProps<TData, TValue> {
  columns: ColumnDef<TData, TValue>[]
  data: TData[]
  searchKey: string
  refetch?: any
  isRefetching?: boolean
}

export function DataTable<TData, TValue>({
  columns,
  data,
  searchKey,
  refetch,
  isRefetching,
}: DataTableProps<TData, TValue>) {
  const table = useReactTable({
    data,
    columns,
    getCoreRowModel: getCoreRowModel(),
    getFilteredRowModel: getFilteredRowModel(),
    getPaginationRowModel: getPaginationRowModel(),
    getSortedRowModel: getSortedRowModel(),
  })

  /* this can be used to get the selectedrows 
  console.log("value", table.getFilteredSelectedRowModel()); */

  return (
    <div className='space-y-3 px-8'>
      <section className='flex items-center'>
        <Input
          placeholder={`Search ${searchKey}...`}
          value={(table.getColumn(searchKey)?.getFilterValue() as string) ?? ''}
          onChange={(event) => table.getColumn(searchKey)?.setFilterValue(event.target.value)}
          className='w-full md:max-w-sm'
        />

        {refetch && (
          <CustomTooltip text='Refresh' className='ml-2'>
            <Button size='icon' variant='secondary' onClick={refetch} disabled={isRefetching}>
              <RefreshCcw width={16} height={16} />
            </Button>
          </CustomTooltip>
        )}
        <DataTableViewOptions table={table} />
      </section>

      {/* Table Rows */}
      <ScrollArea className='h-[calc(80vh-220px)] rounded-md border md:h-[calc(80dvh-200px)]'>
        <Table className='relative'>
          <TableHeader>
            {table.getHeaderGroups().map((headerGroup) => (
              <TableRow key={headerGroup.id}>
                {headerGroup.headers.map((header) => {
                  return (
                    <TableHead key={header.id}>
                      {header.isPlaceholder ? null : flexRender(header.column.columnDef.header, header.getContext())}
                    </TableHead>
                  )
                })}
              </TableRow>
            ))}
          </TableHeader>
          <TableBody>
            {table.getRowModel().rows?.length ? (
              table.getRowModel().rows.map((row) => (
                <TableRow key={row.id} data-state={row.getIsSelected() && 'selected'}>
                  {row.getVisibleCells().map((cell) => (
                    <TableCell key={cell.id}>{flexRender(cell.column.columnDef.cell, cell.getContext())}</TableCell>
                  ))}
                </TableRow>
              ))
            ) : (
              <TableRow>
                <TableCell colSpan={columns.length} className='h-24 text-center'>
                  No results.
                </TableCell>
              </TableRow>
            )}
          </TableBody>
        </Table>
        <ScrollBar orientation='horizontal' />
      </ScrollArea>

      <DataTablePagination table={table} />
    </div>
  )
}
