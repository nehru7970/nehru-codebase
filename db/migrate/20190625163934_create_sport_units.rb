class CreateSportUnits < ActiveRecord::Migration[5.2]
  def change
    create_table :sport_units do |t|
      t.string :sport_unit_name
      t.references :sport, foreign_key: true

      t.timestamps
    end
  end
end
