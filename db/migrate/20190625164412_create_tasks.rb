class CreateTasks < ActiveRecord::Migration[5.2]
  def change
    create_table :tasks do |t|
      t.string :task_name
      t.string :category_event_general
      t.string :task_target_list
      t.references :sport, foreign_key: true

      t.timestamps
    end
  end
end
