'use client';

import { Checkbox } from '@/components/ui/checkbox';
import { Categories } from '@/dto/types/article.type';
import { formatDate, truncate } from '@/lib/utils';
import { ColumnDef } from '@tanstack/react-table';
import { DataTableColumnHeader } from '../../../data-table/column-header';
import { CellAction } from './cell';

export const columns: ColumnDef<Categories>[] = [
  {
    accessorKey: 'name',
    header: ({ column }) => <DataTableColumnHeader column={column} title='Name' />,
  },
  {
    accessorKey: 'description',
    header: 'description',
    cell: ({ row }: any) => truncate(row.getValue('description'), 20),
  },
  {
    accessorKey: 'subCategories',
    header: 'SubCategories',
    cell: ({ row }: any) => row.getValue('subCategories')?.length,
  },
  {
    accessorKey: 'createdBy',
    header: 'Created By',
    cell: ({ row }: any) => {
      const user = row.getValue('createdBy');
      if (user && user.name) {
        return <span>{user.name}</span>;
      } else {
        return <span>--</span>;
      }
    },
  },
  {
    accessorKey: 'createdAt',
    header: ({ column }) => <DataTableColumnHeader column={column} title='Created At' />,
    cell: ({ row }) => {
      const purchasedDate: string = row.getValue('createdAt');
      if (purchasedDate) {
        return <span>{formatDate(purchasedDate)}</span>;
      } else {
        return <span>-</span>;
      }
    },
  },
  {
    id: 'actions',
    cell: ({ row }) => <CellAction data={row.original} />,
  },
];
