class CreateChallenges < ActiveRecord::Migration[5.2]
  def change
    create_table :challenges do |t|
      t.string :state
      t.string :type
      t.string :creation_message
      t.string :main_task_list
      t.string :event
      t.string :parent_task_list
      t.binary :requirements

      t.timestamps
    end
  end
end
