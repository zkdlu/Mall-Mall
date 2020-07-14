import axios from 'axios';
import {ApiConfig} from './ApiConfig';

export function Api_getArticles() {
    const url = `${ApiConfig.API_URL}/articles`;
    console.log(url);

    return axios.get(`${ApiConfig.API_URL}/articles`);
}