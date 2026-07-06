# Todo List Application

Ứng dụng quản lý công việc (Todo List) được xây dựng bằng Spring Boot, hỗ trợ cả backend API và giao diện (Thymeleaf).

## Công nghệ sử dụng

- Java 25 (Temurin 25.0.3 LTS)
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Thymeleaf

## Yêu cầu

- Java 17+ (nếu chạy bằng Maven)
- Maven 3.9+
- Docker (nếu chạy bằng Dockerfile)

---

## Chạy ứng dụng

### Cách 1: Chạy bằng Maven

```bash
mvn spring-boot:run
```

Hoặc

```bash
mvn clean package
java -jar target/*.jar
```

Ứng dụng sẽ chạy tại:

```
http://localhost:8080
```

---

### Cách 2: Chạy bằng Docker

#### Build image

```bash
docker build -t todo-api .
```

#### Run container

```bash
docker run -p 8080:8080 todo-api
```

Ứng dụng sẽ chạy tại:

```
http://localhost:8080
```

---

## Database

Dự án sử dụng H2 database (file-based).

- JDBC URL: `jdbc:h2:file:./data/todo`
- Username: `sa`
- Password: *(empty)*

---

## API

Base URL:

```
http://localhost:8080/api/todos
```
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/` | Tạo công việc |
| `GET` | `/` | Lấy danh sách công việc |
| `GET` | `/{id}` | Lấy công việc theo ID |
| `PATCH` | `/{id}` | Cập nhật công việc |
| `DELETE` | `/{id}` | Xóa công việc |
| `GET` | `/completed` | Lọc theo trạng thái (query param `completed`) |
| `GET` | `/search` | tìm kiếm theo từ khóa (`keyword`) |
| `POST` | `/{id}/complete` | Toggle trạng thái hoàn thành |
