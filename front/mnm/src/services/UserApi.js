import axios from 'axios';
import {ApiConfig} from './ApiConfig';

export function checkOverlap(check_user_id) {
    return axios.get(`${ApiConfig.API_URL}/join`, {
      params: {
        user_id: check_user_id
      }
    });
}

export function join(name, user_id, password, gender, home_address, phone_number) {
    return axios.post(`${ApiConfig.API_URL}/join`, {
      name: name,
      user_id: user_id,
      passwd: password,
      gender: gender,
      home_address: home_address,
      phone_number: phone_number
    });
}

export function login(user_id, password) {
  return axios.post("http://localhost:8080/login", {
    user_id: user_id,
    passwd: password
  });
}