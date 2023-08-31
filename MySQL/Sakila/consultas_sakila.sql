-- Consultas

-- ¿Qué consulta ejecutarías para obtener todos los clientes dentro de city_id = 312?
SELECT address.city_id AS ciudad_id, customer.first_name AS nombre, customer.last_name AS apellido, customer.email AS mail, address.address as direccion
FROM customer
JOIN address ON customer.address_id = address.address_id
WHERE address.city_id = 312;

-- ¿Qué consulta harías para obtener todas las películas de comedia? 
SELECT * FROM film
JOIN film_category ON film.film_id = film_category.film_id
JOIN category ON film_category.category_id = category.category_id
WHERE category.name = 'Comedy';

-- ¿Qué consulta harías para obtener todas las películas unidas por actor_id = 5?
SELECT actor.first_name AS nombre, actor.last_name AS apellido, film_actor.actor_id AS actor_id, film.title AS titulo, film.description AS descripcion, film.release_year AS estreno
FROM film
JOIN film_actor ON film.film_id = film_actor.film_id
JOIN actor ON film_actor.actor_id = actor.actor_id
WHERE film_actor.actor_id = 5;

-- ¿Qué consulta ejecutaría para obtener todos los clientes en store_id = 1 y dentro de estas ciudades (1, 42, 312 y 459)?
SELECT city.city_id AS ciudad_id, store.store_id AS tienda_id, customer.first_name AS nombre, customer.last_name AS apellido, customer.email AS mail, address.address AS direccion
FROM customer
JOIN store ON customer.store_id = store.store_id
JOIN address ON customer.address_id = address.address_id
JOIN city ON address.city_id = city.city_id
WHERE store.store_id = 1 AND city.city_id IN (1, 42, 312, 459);

-- ¿Qué consulta realizarías para obtener todas las películas con una "calificación = G" y "característica especial = detrás de escena", unidas por actor_id = 15?
SELECT film.title AS titulo, film.description AS descripcion, film.release_year AS estreno, film.rating AS clasificacion, film.special_features AS caracteristicas_especiales
FROM film
JOIN film_actor ON film_actor.film_id = film.film_id
WHERE film.rating = "G" AND actor_id = 15 AND film.special_features LIKE "%Behind the Scenes%";

-- ¿Qué consulta harías para obtener todos los actores que se unieron en el film_id = 369?
SELECT film.film_id AS pelicula_id, film.title AS titulo, actor.actor_id AS actor_id, CONCAT(actor.first_name, ' ', actor.last_name) AS nombre_apellido
FROM film
JOIN film_actor ON film.film_id = film_actor.film_id
JOIN actor ON film_actor.actor_id = actor.actor_id
WHERE film_actor.film_id = 369;


-- ¿Qué consulta harías para obtener todas las películas dramáticas con una tarifa de alquiler de 2.99? 
SELECT film.title AS titulo, film.description AS descripcion, film.release_year AS estreno, film.rating AS clasificación, film.special_features AS características_especiales, category.name AS categoria, film.rental_rate AS precio
FROM film
JOIN film_category ON film.film_id = film_category.film_id
JOIN category ON film_category.category_id = category.category_id
WHERE film.rental_rate = 2.99 AND category.name='drama';


-- ¿Qué consulta harías para obtener todas las películas de acción a las que se une SANDRA KILMER?
SELECT CONCAT(actor.first_name, ' ', actor.last_name) AS actor, film.title AS titulo, film.description AS descripcion, film.release_year AS estreno, film.rating AS clasificación, film.special_features AS características_especiales, category.name AS genero
FROM film
JOIN film_category ON film.film_id = film_category.film_id
JOIN category ON film_category.category_id = category.category_id
JOIN film_actor ON film.film_id = film_actor.film_id
JOIN actor ON film_actor.actor_id = actor.actor_id
WHERE category.name = 'action' AND actor.first_name ='Sandra' AND actor.last_name = 'Kilmer';
