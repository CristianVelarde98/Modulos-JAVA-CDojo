-- ¿Qué consulta harías para obtener todos los países que hablan esloveno?
SELECT countries.name AS pais, languages.language AS lengua, languages.percentage AS porcentaje
FROM countries
JOIN languages ON countries.id = languages.country_id
WHERE languages.language = 'Slovene'
ORDER BY languages.percentage DESC;


-- ¿Qué consulta ejecutarías para mostrar el número total de ciudades para cada país?       
SELECT countries.name AS pais, COUNT(cities.id) AS ciudades
FROM countries
LEFT JOIN cities ON countries.id = cities.country_id
GROUP BY countries.id, countries.name
ORDER BY ciudades ASC;


-- ¿Qué consulta harías para obtener todas las ciudades de México con una población de más de 500,000?
SELECT cities.name AS ciudad, cities.population as poblacion
FROM cities
WHERE cities.country_code = "MEX" AND cities.population > 500000 
ORDER BY poblacion DESC;

-- ¿Qué consulta ejecutarías para obtener todos los idiomas en cada país con un porcentaje superior al 89%?
SELECT countries.name AS pais, languages.language AS idioma, languages.percentage AS porcentaje
FROM countries
JOIN languages ON countries.id = languages.country_id
WHERE languages.percentage > 89
ORDER BY languages.percentage ASC;

-- ¿Qué consulta haría para obtener todos los países con un área de superficie inferior a 501 y una población superior a 100,000?
SELECT countries.name AS pais
FROM countries
WHERE surface_area < 501 AND population > 100000;

-- ¿Qué consulta harías para obtener países con solo Monarquía Constitucional con un capital superior a 200 y una esperanza de vida superior a 75 años?
SELECT countries.name AS pais
FROM countries
WHERE government_form = 'Constitutional Monarchy' AND capital > 200 AND life_expectancy > 75;

-- ¿Qué consulta harías para obtener todas las ciudades de Argentina dentro del distrito de Buenos Aires y tener una población superior a 500,000? 
SELECT countries.name AS pais, cities.name AS ciudad, cities.district, cities.population
FROM countries
JOIN cities ON countries.id = cities.country_id
WHERE countries.name = 'Argentina' AND cities.district = 'Buenos Aires' AND cities.population > 500000;

-- ¿Qué consulta harías para resumir el número de países en cada región?
SELECT countries.region AS region, COUNT(*) AS paises
FROM countries
GROUP BY region
ORDER BY paises DESC;





