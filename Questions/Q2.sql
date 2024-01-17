SELECT user_code AS 'User', COUNT(id) AS 'Packed Count' 
    FROM order_tote_process_log 
    WHERE action_code = 'PACKED' AND process_date BETWEEN '2023-11-01 10:00:00' AND '2023-11-01 10:59:59'
    GROUP BY user_code



/*===============OUTPUT===================*/
/*

User    Packed Count
 P1          1

*/
