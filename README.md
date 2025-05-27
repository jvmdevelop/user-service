

# Для старта: 
Linux: 
```bash
sudo pacman -Suy
sudo pacman -S docker docker-compose
chmod +x start.sh
./start.sh
```

Windows:
```bash
./mvnw clean package -DskipTests
docker-compose up --build
```