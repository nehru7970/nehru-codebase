class UserChallenge < ApplicationRecord
  belongs_to :challenge
  belongs_to :user
  belongs_to :task
end
