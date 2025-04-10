# DepthfirstBackendAssignment
internship assignment

## 🚀 Run Server (Docker)
```bash
 docker-compose up -d
```

## 📬 API Endpoints
| Method | Endpoint | Description |
| --- | --- | --- |
| POST | `/register` | Register new user |
| POST | `/login` | Login and get JWT |
| GET | `/getUserProfile` | Get current user info | 
| POST | `/logout` | logout and remove JWT |

## 🧪 Test API

📥 Import [Postman Collection](postman_collection.json) into Postman for quick testing. \

> ⚠️ Be sure to **create or select an environment** before testing.

The collection includes preconfigured requests for: 
* Register
* Login
* Get Profile
* Logout
