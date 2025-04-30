# Food Order System

## Layihənin Məqsədi
Bu layihə restoranın menyu idarəsi və sifariş sistemini rəqəmsal mühitdə təmin etmək üçün hazırlanmışdır. İstifadəçilər qeydiyyatdan keçə, sistemə daxil ola, menyuya baxa və sifariş verə bilərlər. Eyni zamanda adminlər menyunu və sifariş statuslarını idarə edə bilər.

## Texnologiyalar
- **Backend**: Java 17, Spring Boot, Spring Security, JWT, Spring Data JPA, Hibernate
- **Database**: Oracle
- **Security**: JWT ilə autentifikasiya və rollara əsaslanan avtorizasiya
- **Mapper**: MapStruct
- **Sənədləşmə**: Swagger (OpenAPI)
- **Frontend**: Thymeleaf

## Əsas Funksiyalar
- İstifadəçi qeydiyyatı və giriş (JWT token ilə)
- Menyuya baxış və admin üçün idarəetmə
- Sifarişin yaradılması və statusun izlənməsi
- Xərclərin planlaşdırılması (Expense Plan)
- Admin və User rollarına əsaslanan icazə sistemləri

## İstifadəçi Rolları
- **ROLE_USER**: menyuya baxış, sifariş vermə
- **ROLE_ADMIN**: menyu yaratma, silmə, sifariş statuslarını dəyişmə

## API Əsas Endpoints
- `POST /api/auth/register` – Qeydiyyat
- `POST /api/auth/login` – Giriş və JWT alınması
- `GET /api/menu` – Menyu maddələrinə baxış
- `POST /api/menu` – Menyuya əlavə (Admin)
- `POST /api/orders` – Yeni sifariş yaratmaq
- `GET /api/orders/{id}` – Sifariş detalları
- `POST /api/expenses` – Yeni xərcləmə planı (Expense Plan)


