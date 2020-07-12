import axios from 'axios';

export function checkOverlap(check_user_id) {
    return axios.get("http://localhost:8080/join", {
      params: {
        user_id: check_user_id
      }
    });
}

export function join(name, user_id, password, gender, home_address, phone_number) {
    return axios.post("http://localhost:8080/join",
    {
      name: name,
      user_id: user_id,
      passwd: password,
      gender: gender,
      home_address: home_address,
      phone_number: phone_number
    });
}