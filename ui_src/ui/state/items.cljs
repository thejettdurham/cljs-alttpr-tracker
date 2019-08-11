(ns ui.state.items
  (:require [reagent.core :refer [atom]]))

(defonce items (atom {:bow             0
                      :boomerang       0
                      :hookshot        0
                      :bomb            0
                      :mushroom-powder 0
                      :fire-rod        0
                      :ice-rod         0
                      :bombos          0
                      :ether           0
                      :quake           0
                      :lamp            0
                      :hammer          0
                      :shovel-flute    0
                      :net             0
                      :book            0
                      :bottle          0
                      :red-cane        0
                      :blue-cane       0
                      :cape            0
                      :mirror          0}))

(def statuses {:bow             4
               :boomerang       4
               :hookshot        2
               :bomb            2
               :mushroom-powder 4
               :fire-rod        2
               :ice-rod         2
               :bombos          2
               :ether           2
               :quake           2
               :lamp            2
               :hammer          2
               :shovel-flute    4
               :net             2
               :book            2
               :bottle          5
               :red-cane        2
               :blue-cane       2
               :cape            2
               :mirror          2})

(defn increment-item-status
  "given an item keyword updates the items atom with the given item status incremented"
  [item]
  (let [item-status-count (item statuses)
        next-item (->> @items item inc (#(mod % item-status-count)))]
    (swap! items assoc item next-item)))

(defn decrement-item-status
  "given an item keyword updates the items atom with the given item status decremented"
  [item]
  (let [item-status-count (item statuses)
        next-item (->> @items item dec (#(mod % item-status-count)))]
    (swap! items assoc item next-item)))