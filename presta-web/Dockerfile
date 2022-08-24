
# Client App
FROM node:14 as builder
ARG env=prod
LABEL authors="Asma MEHRZI"
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY package.json ./
RUN npm install --silent
RUN npm install @angular/cli -g

COPY . .
RUN npm run build:$env
EXPOSE 80
CMD ["npm","start"]