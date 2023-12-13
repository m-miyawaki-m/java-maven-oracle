CREATE OR REPLACE PROCEDURE select_product_codes (p_condition IN VARCHAR2, cur OUT SYS_REFCURSOR) AS
BEGIN
  IF p_condition = 'Even' THEN
    OPEN cur FOR SELECT * FROM product_details_view WHERE MOD(Product_Code, 2) = 0;
  ELSIF p_condition = 'Odd' THEN
    OPEN cur FOR SELECT * FROM product_details_view WHERE MOD(Product_Code, 2) = 1;
  ELSE
    OPEN cur FOR SELECT * FROM product_details_view;
  END IF;
END select_product_codes;