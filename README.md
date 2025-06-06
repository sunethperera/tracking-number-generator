Steps to setup, run and test the tracking number generator API
1. clone the project to the local environment where there is java support(I have used JDK version 21 here).
2. open the project through a preferred IDE that support java(I used Intellij idea tool for this)
3. Run the project from the IDE and test the application through either browser or a separate API tool such as postman.

This API requires below parameters to be provided in the request URL
1. origin_country_id : The order’s origin country code in ISO 3166-1 alpha-2 format (e.g., "MY")
2. destination_country_id : The order’s destination country code in ISO 3166-1 alpha-2 format (e.g., "ID")
3. weight : The order’s weight in kilograms, up to three decimal places (e.g., "1.234")
4. created_at : The order’s creation timestamp in RFC 3339 format (e.g., "2018-11-20T19:29:32+08:00")
5. customer_id  The customer’s UUID (e.g., "de619854-b59b-425e-9db4-943979e1bd49")
6. customer_name : The customer’s name (e.g., "RedBox Logistics")
7. customer_slug : The customer’s name in slug-case/kebab-case (e.g., "redbox-logistics")

   
Sample sucess request -> localhost:8080/next-tracking-number?origin_country_id=MY&destination_country_id=SL&weight=1.234&created_at=2018-11-20T19:28:32%2B08:00&customer_id=de619854-b59b-425e-9db4-943979e1bd49&customer_name=RedBox Logistics&customer_slug=redbox-logistics

Sample request for invalid country id -> localhost:8080/next-tracking-number?origin_country_id=abc&destination_country_id=SL&weight=1.234&created_at=2018-11-20T19:28:32%2B08:00&customer_id=de619854-b59b-425e-9db4-943979e1bd49&customer_name=RedBox Logistics&customer_slug=redbox-logistics

Sample request for invalid weight -> localhost:8080/next-tracking-number?origin_country_id=MY&destination_country_id=SL&weight=1.2345&created_at=2018-11-20T19:28:32%2B08:00&customer_id=de619854-b59b-425e-9db4-943979e1bd49&customer_name=RedBox Logistics&customer_slug=redbox-logistics


prerequisites -> Java (JDK version 21), Maven, git and a preferred IDE.
