import axios from "axios";

export default axios.create({
  baseURL: "http://localhost:8080/",
  headers: {
    "Content-type": "application/json",
    "Access-Control-Allow-Methods" : "GET, POST, OPTIONS, PUT, DELETE"
  }
});
