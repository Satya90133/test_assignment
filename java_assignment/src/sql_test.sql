
--	1.Please write a SQL query to search for the latest order with quantity larger than X.

SELECT *
FROM your_table_name
WHERE quantity > X                --	Replace X with the desired quantity threshold.
ORDER BY order_date DESC
    LIMIT 1;


--2. Please write a SQL query to list down for each customer how many orders they have made respectively.
SELECT customer_name, COUNT(order_id) AS num_orders
FROM orders
GROUP BY customer_name;