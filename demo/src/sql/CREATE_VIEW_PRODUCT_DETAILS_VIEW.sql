CREATE OR REPLACE VIEW product_details_view AS
SELECT
    pr.PRODUCT_CODE,pn.product_category_name,pr.product_name,pr.unit_price,pr.last_arrival_date,pr.model_number,pr.discounted_price
FROM
    hr.PRODUCT pr
LEFT OUTER JOIN hr.product_category pn
ON pr.product_category_code = pn.product_category_code;