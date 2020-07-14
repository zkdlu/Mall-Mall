import axios from 'axios';
import { ApiConfig } from './ApiConfig';

export function Api_getArticles() {
  return axios.get(`${ApiConfig.API_URL}/articles`);
}

export function Api_getArticle(pk) {
  return axios.get(`${ApiConfig.API_URL}/articles/${pk}`);
}

export function Api_insertArticle(user_id, product_name, product_stock,
    product_price, product_description, category, title, description) {

  return axios.post(`${ApiConfig.API_URL}/articles`, {
    user: {
      user_id: user_id
    },
    product: {
      name: product_name,
      stock: product_stock,
      sales: 0,
      price: product_price,
      description: product_description,
      state: 0
    },
    category: {
      name: category,
      state: 0
    },
    title: title,
    description: description,
    hits: 0,
    state: 0
  });
}
