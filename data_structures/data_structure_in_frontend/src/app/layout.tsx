import RootProvider from '@/providers/root-provider';
import type { Metadata } from 'next';
import { Inter } from 'next/font/google';
import './globals.css';

const inter = Inter({ subsets: ['latin'] });

export const metadata: Metadata = {
  title: 'Data Structure and Algorithms',
  description: 'This is the Data Structure and Algorithms in Frontend',
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang='en' suppressHydrationWarning={true}>
      <body className={`${inter.className} overflow-hidden`}>
        <RootProvider>{children}</RootProvider>
      </body>
    </html>
  );
}
