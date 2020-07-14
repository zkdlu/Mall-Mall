import axios from 'axios';
import {ApiConfig} from './ApiConfig';

export function Api_getCategories() {
    return axios.get(`${ApiConfig.API_URL}/categories`);
}