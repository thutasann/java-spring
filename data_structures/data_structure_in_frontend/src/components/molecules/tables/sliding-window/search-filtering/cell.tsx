'use client';

import { Button } from '@/components/ui/button';
import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuLabel,
  DropdownMenuTrigger,
} from '@/components/ui/dropdown-menu';
import { useToast } from '@/components/ui/use-toast';
import { Categories } from '@/dto/types/article.type';
import { PageEndpoints } from '@/lib/constants/page-endpoint';
import { useMutateQuery } from '@/lib/hooks/react-query/use-query';
import { useQueryClient } from '@tanstack/react-query';
import { Edit, MoreHorizontal, Trash } from 'lucide-react';
import { useRouter } from 'next/navigation';
import { useState } from 'react';
import { AlertModal } from '../../../modal/alert-modal';

interface ICellAction {
  data: Categories;
}

export const CellAction: React.FC<ICellAction> = ({ data }) => {
  const { mutate, isPending } = useMutateQuery();
  const { toast } = useToast();
  const queryClient = useQueryClient();
  const [open, setOpen] = useState(false);
  const router = useRouter();

  const onConfirm = () => {
    mutate(
      {
        url: `/categories/${data._id}`,
        method: 'DELETE',
      },
      {
        onSuccess: (res) => {
          queryClient.invalidateQueries({ queryKey: ['/categories'] });
          if (res.data) {
            toast({
              title: 'Category Deleted!',
            });
            setOpen(false);
          } else {
            toast({
              title: 'Category Delete Fail!',
              description: res.data.meta.message,
            });
            setOpen(false);
          }
        },
        onError: (err) => {
          toast({
            title: 'Something went wrong!',
            description: err.message,
          });
          setOpen(false);
        },
      },
    );
  };

  return (
    <>
      <AlertModal
        title='Are you sure, you want to delete that category ?'
        isOpen={open}
        onClose={() => setOpen(false)}
        onConfirm={onConfirm}
        loading={isPending}
      />

      <DropdownMenu modal={false}>
        <DropdownMenuTrigger asChild>
          <Button variant='ghost' className='h-8 w-8 p-0'>
            <MoreHorizontal className='h-4 w-4' />
          </Button>
        </DropdownMenuTrigger>
        <DropdownMenuContent align='end'>
          <DropdownMenuLabel>Actions</DropdownMenuLabel>

          <DropdownMenuItem onClick={() => router.push(`${PageEndpoints.slidingWindow.index}/edit/${data._id}`)}>
            <Edit className='mr-2 h-4 w-4' /> Update
          </DropdownMenuItem>
          <DropdownMenuItem onClick={() => setOpen(true)}>
            <Trash className='mr-2 h-4 w-4' /> Delete
          </DropdownMenuItem>
        </DropdownMenuContent>
      </DropdownMenu>
    </>
  );
};
