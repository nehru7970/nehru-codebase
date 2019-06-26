class CreateChallengeTasks < ActiveRecord::Migration[5.2]
  def change
    create_table :challenge_tasks do |t|
      t.string :type
      t.references :challenge, foreign_key: true
      t.references :task, foreign_key: true

      t.timestamps
    end
  end
end
