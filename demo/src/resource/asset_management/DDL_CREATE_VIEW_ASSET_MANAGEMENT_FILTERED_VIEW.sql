CREATE OR REPLACE VIEW asset_management_filtered_view AS
SELECT asset_classification,acquisition_date,acquisition_cost FROM asset_management
WHERE asset_classification = '土地';