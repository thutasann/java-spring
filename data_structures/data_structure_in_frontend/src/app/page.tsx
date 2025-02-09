import { redirect } from 'next/navigation';

function RootPage() {
  redirect('/dashboard');
}

export default RootPage;
