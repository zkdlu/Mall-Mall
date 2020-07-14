import axios from 'axios';
import {ApiConfig} from './ApiConfig';

export function Api_getArticles() {
    return axios.get(`${ApiConfig.API_URL}/articles`);
}

export function Api_getArticle(pk) {
    return axios.get(`${ApiConfig.API_URL}/articles/${pk}`);
}
