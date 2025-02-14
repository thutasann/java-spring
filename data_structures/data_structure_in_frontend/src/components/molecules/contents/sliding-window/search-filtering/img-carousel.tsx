import { images } from '@/lib/constants/images';
import { ChevronLeftCircle, ChevronLeftIcon, ChevronRightIcon } from 'lucide-react';
import Image from 'next/image';
import React, { useCallback, useRef, useState } from 'react';

type CarrouselProps = {
  images: string[];
};

function Carousel({ images }: CarrouselProps) {
  const [currentIndex, setCurrentIndex] = useState(0);
  const nextSlide = () => setCurrentIndex((prev) => (prev + 1) % images.length);
  const prevSlide = () => setCurrentIndex((prev) => (prev - 1) % images.length);

  return (
    <div className='relative w-full max-w-lg mx-auto'>
      <div className='overflow-hidden rounded-lg shadow-lg'>
        <div
          className='flex transition-transform duration-500 ease-in-out'
          style={{ transform: `translateX(-${currentIndex * 100}%)` }}
        >
          {images.map((image, index) => (
            <Image
              key={index}
              src={image}
              alt={`Slide ${index}`}
              className='w-full flex-shrink-0'
              width={300}
              height={300}
            />
          ))}
        </div>
      </div>

      <button
        onClick={prevSlide}
        className='absolute left-[-50px] top-1/2 transform -translate-y-1/2 bg-primary p-2 rounded-full shadow-md'
      >
        <ChevronLeftIcon />
      </button>
      <button
        onClick={nextSlide}
        className='absolute right-[-50px] top-1/2 transform -translate-y-1/2 bg-primary p-2 rounded-full shadow-md'
      >
        <ChevronRightIcon />
      </button>
    </div>
  );
}

function ImageCarousel() {
  return <Carousel images={images} />;
}

export default ImageCarousel;
