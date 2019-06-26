class CreateTaskTargets < ActiveRecord::Migration[5.2]
  def change
    create_table :task_targets do |t|
      t.integer :quantity
      t.string :scoring_details
      t.references :sport_unit, foreign_key: true

      t.timestamps
    end
  end
end
