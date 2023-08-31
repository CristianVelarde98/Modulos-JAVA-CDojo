-- Consultas

-- ¿Qué consulta ejecutaría para obtener los ingresos totales para marzo de 2012?
SELECT 'marzo' AS mes, SUM(amount) AS ingresos
FROM billing
WHERE charged_datetime BETWEEN '2012-03-01' AND '2012-04-01';

-- ¿Qué consulta ejecutaría para obtener los ingresos totales recaudados del cliente con una identificación de 2?
SELECT client_id AS cliente_id, SUM(amount) AS ingresos
FROM billing
WHERE client_id = 2;

-- ¿Qué consulta ejecutaría para obtener todos los sitios que posee client = 10?
SELECT domain_name AS dominio, client_id AS  cliente_id
FROM sites
WHERE client_id = 10;

-- ¿Qué consulta ejecutaría para obtener el número total de sitios creados por mes por año para el cliente con una identificación de 1? ¿Qué pasa con el cliente = 20?
SELECT client_id AS cliente_id, COUNT(domain_name) AS sitios_creados, MONTHNAME(created_datetime) AS mes , YEAR(created_datetime) AS año
FROM sites
WHERE client_id = 20 OR client_id = 1 
GROUP BY client_id, YEAR(created_datetime), MONTHNAME(created_datetime);

-- ¿Qué consulta ejecutaría para obtener el número total de clientes potenciales generados para cada uno de los sitios entre el 1 de enero de 2011 y el 15 de febrero de 2011?
SELECT sites.domain_name AS dominios, Count(leads.leads_id) AS clientes_potenciales, leads.registered_datetime AS registro
FROM sites
LEFT JOIN leads ON sites.site_id = leads.site_id
WHERE leads.registered_datetime BETWEEN '2011-01-01' AND '2011-02-16'
GROUP BY dominios, registro;

--  ¿Qué consulta ejecutaría para obtener una lista de nombres de clientes y el número total de clientes potenciales que hemos generado para cada uno de nuestros clientes entre el 1 de enero de 2011 y el 31 de diciembre de 2011?
SELECT CONCAT(clients.first_name, ' ', clients.last_name) AS cliente, count(leads.leads_id) AS total_potenciales
FROM leads
LEFT JOIN sites ON leads.site_id = sites.site_id
LEFT JOIN clients ON sites.client_id = clients.client_id
WHERE leads.registered_datetime BETWEEN '2011-01-01' AND '2012-01-01'
GROUP BY cliente
ORDER BY clients.client_id;

-- ¿Qué consulta ejecutaría para obtener una lista de nombres de clientes y el número total de clientes potenciales que hemos generado para cada cliente cada mes entre los meses 1 y 6 del año 2011?
SELECT CONCAT(clients.first_name, ' ', clients.last_name) AS cliente, 
count(leads.leads_id) AS total_potenciales, MONTHNAME(leads.registered_datetime) AS mes
FROM leads
LEFT JOIN sites ON leads.site_id = sites.site_id
LEFT JOIN clients ON sites.client_id = clients.client_id
WHERE leads.registered_datetime BETWEEN '2011-01-01' AND '2011-07-01'
GROUP BY cliente, mes
ORDER BY leads.registered_datetime;

-- ¿Qué consulta ejecutaría para obtener una lista de nombres de clientes y el número total de clientes potenciales que hemos generado para cada uno de los sitios de nuestros clientes entre el 1 de enero de 2011 y el 31 de diciembre de 2011? 
SELECT CONCAT(clients.first_name, ' ', clients.last_name) AS cliente, sites.domain_name AS dominio,
count(leads.leads_id) AS potenciales_generados
FROM leads
LEFT JOIN sites ON leads.site_id = sites.site_id
LEFT JOIN clients ON sites.client_id = clients.client_id
WHERE leads.registered_datetime BETWEEN '2011-01-01' AND '2012-01-01'
GROUP BY cliente, dominio
ORDER BY clients.client_id;

SELECT CONCAT(clients.first_name, ' ', clients.last_name) AS cliente, sites.domain_name AS dominio,
count(leads.leads_id) AS potenciales_generados
FROM leads
LEFT JOIN sites ON leads.site_id = sites.site_id
LEFT JOIN clients ON sites.client_id = clients.client_id
WHERE leads.registered_datetime IS NOT NULL
GROUP BY cliente, dominio, clients.client_id
ORDER BY clients.client_id ASC, potenciales_generados DESC;

-- Escriba una sola consulta que recupere los ingresos totales recaudados de cada cliente para cada mes del año. Pídalo por ID de cliente.
SELECT CONCAT(clients.first_name, ' ', clients.last_name) AS cliente, SUM(billing.amount) AS monto, MONTHNAME(billing.charged_datetime) AS mes, YEAR(billing.charged_datetime) AS año
FROM clients
LEFT JOIN billing ON clients.client_id = billing.client_id
GROUP BY cliente, mes, año, clients.client_id
ORDER BY clients.client_id, billing.charged_datetime;

--  Escriba una sola consulta que recupere todos los sitios que posee cada cliente. Agrupe los resultados para que cada fila muestre un nuevo cliente.
SELECT CONCAT(clients.first_name, ' ', clients.last_name) AS cliente, GROUP_CONCAT(sites.domain_name, " / ") AS dominios
FROM clients
LEFT JOIN sites ON clients.client_id = sites.client_id
GROUP BY cliente
ORDER BY clients.client_id;

