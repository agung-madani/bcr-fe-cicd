FROM node:20-alpine

WORKDIR /app

# Copy package files first to leverage Docker caching
COPY package.json package-lock.json /app/

RUN npm install --legacy-peer-deps
RUN npm i -g serve

COPY . /app/

# Fix esbuild binary issue
RUN npm rebuild esbuild && npm install esbuild --force

RUN npm run build

EXPOSE 3000

CMD [ "serve", "-s", "dist" ]