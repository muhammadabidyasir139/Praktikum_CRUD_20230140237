![task get crud](https://github.com/user-attachments/assets/fa854cde-2418-4515-80e3-8c34aea6f949)

# User API Documentation

---

## Base URL
Semua endpoint berada di bawah path:
```text
/api/users
```

---

## Struktur Data

### User Request (Payload)
Digunakan saat melakukan `POST` dan `PUT`.
```json
{
  "name": "string",
  "age": 0
}
```

### User Response (Data)
Data objek `User` yang direturn oleh sistem.
```json
{
  "id": "string (UUID)",
  "name": "string",
  "age": 0
}
```

---

## Endpoints

### 1. Menambahkan User Baru
Membuat data user baru.

- **URL:** `/api/users`
- **Method:** `POST`
- **Headers:** `Content-Type: application/json`
- **Request Body:**

  ```json
  {
    "name": "John Doe",
    "age": 25
  }
  ```

- **Success Response (201 Created):**

  ```json
  {
    "status": "success",
    "data": {
      "id": "123e4567-e89b-12d3-a456-426614174000",
      "name": "John Doe",
      "age": 25
    }
  }
  ```

- **Failure Response (400 Bad Request):**
  Akan terjadi error validasi (ConstraintViolationException) jika data yang dikirim tidak sesuai/kosong.
  ```json
  {
      "timestamp": "2024-03-04T10:00:00.000+00:00",
      "status": 400,
      "error": "Bad Request",
      "path": "/api/users"
  }
  ```

---

### 2. Mengambil Semua Data User
Mendapatkan daftar seluruh user yang ada di database.

- **URL:** `/api/users`
- **Method:** `GET`
- **Success Response (200 OK):**

  ```json
  {
    "status": "success",
    "data": [
      {
        "id": "123e4567-e89b-12d3-a456-426614174000",
        "name": "John Doe",
        "age": 25
      },
      {
        "id": "987fcdeb-51a2-43d7-a982-1234567890ab",
        "name": "Jane Smith",
        "age": 30
      }
    ]
  }
  ```

---

### 3. Mengambil Detail User Berdasarkan ID
Mendapatkan satu spesifik data user menggunakan `ID`.

- **URL:** `/api/users/{id}`
- **Method:** `GET`
- **Success Response (200 OK):**

  ```json
  {
    "status": "success",
    "data": {
      "id": "123e4567-e89b-12d3-a456-426614174000",
      "name": "John Doe",
      "age": 25
    }
  }
  ```

- **Failure Response (500 Internal Server Error):**
  Terjadi jika user tidak ditemukan di database (melempar `RuntimeException("User Not found")`).
  ```json
  {
      "timestamp": "2024-03-04T10:00:00.000+00:00",
      "status": 500,
      "error": "Internal Server Error",
      "message": "User Not found",
      "path": "/api/users/123e4567-e89b-12d3-a456-426614174000"
  }
  ```

---

### 4. Mengubah Data User Berdasarkan ID
Memperbarui data user yang sudah ada.

- **URL:** `/api/users/{id}`
- **Method:** `PUT`
- **Headers:** `Content-Type: application/json`
- **Request Body:**

  ```json
  {
    "name": "John Doe Updated",
    "age": 26
  }
  ```

- **Success Response (200 OK):**

  ```json
  {
    "status": "success",
    "data": {
      "id": "123e4567-e89b-12d3-a456-426614174000",
      "name": "John Doe Updated",
      "age": 26
    }
  }
  ```

- **Failure Response (500 Internal Server Error):**
  Terjadi jika user yang mau di-update tidak ditemukan.
  ```json
  {
      "timestamp": "2024-03-04T10:00:00.000+00:00",
      "status": 500,
      "error": "Internal Server Error",
      "message": "User Not found",
      "path": "/api/users/123e4567-e89b-12d3-a456-426614174000"
  }
  ```

---

### 5. Menghapus User Berdasarkan ID
Menghapus data user dari sistem.

- **URL:** `/api/users/{id}`
- **Method:** `DELETE`
- **Success Response (200 OK):**

  ```json
  {
    "status": "success delete user with id 123e4567-e89b-12d3-a456-426614174000"
  }
  ```

- **Failure Response (500 Internal Server Error):**
  Terjadi jika user yang mau dihapus tidak ditemukan.
  ```json
  {
      "timestamp": "2024-03-04T10:00:00.000+00:00",
      "status": 500,
      "error": "Internal Server Error",
      "message": "user not found",
      "path": "/api/users/123e4567-e89b-12d3-a456-426614174000"
  }
  ```
