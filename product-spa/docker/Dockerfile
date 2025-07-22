# ------------ Stage 1: Build -------------------

FROM node:20-alpine AS builder

WORKDIR /app

COPY ../package*.json ./

RUN npm install

COPY .. .

RUN npm run build --prod

# ------------ Stage 2: Run -------------------
FROM nginx:1.25-alpine

RUN rm -rf /usr/share/nginx/html/*

COPY --from=builder /app/dist/product-spa/browser /usr/share/nginx/html/

RUN echo $(ls -1 /usr/share/nginx/html/)

COPY docker/nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]