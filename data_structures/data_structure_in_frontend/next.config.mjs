/** @type {import('next').NextConfig} */
const nextConfig = {
  images: {
    remotePatterns: [
      {
        hostname: 'res.cloudinary.com',
      },
      {
        hostname: 'images.unsplash.com',
      },
      {
        hostname: 'plus.unsplash.com',
      },
      {
        hostname: 'images.rawpixel.com',
      },
      {
        hostname: 'media.cnn.com',
      },
      {
        hostname: 'images.glints.com',
      },
      {
        hostname: 'img.freepik.com',
      },
    ],
  },
};

export default nextConfig;
