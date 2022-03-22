import http from "../http-common";

class WebService {
  getRate() {
    return http.get(`/getrate`);
  }

  setRate(rate) {
    return http.get(`/setrate?rate=${rate}`);
  }

  convert(amount){
    return http.get(`/convert?amount=${amount}`);
  }

  executeConstructor(data) {
    return http.post("/", data);
  }
}

export default new WebService();
