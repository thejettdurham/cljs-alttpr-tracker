(ns ui.item
  (:require [ui.state.items :as item-state]))

(defn item [key]
  (let [state (key @item-state/items)
        item-status (key item-state/statuses)
        item-name (str "img/items/" (name key) (if (= 2 item-status) "" state) ".png")]
    [:img {:src             item-name
           :class           (if (= state 0) "disabled" "")
           :on-click        #(item-state/increment-item-status key)
           :on-context-menu #(item-state/decrement-item-status key)}]))

(defn items []
  [:div
   [item :bow]
   [item :boomerang]
   [item :hookshot]
   [item :bomb]
   [item :mushroom-powder]
   [item :fire-rod]
   [item :ice-rod]
   [item :bombos]
   [item :ether]
   [item :quake]
   [item :lamp]
   [item :hammer]
   [item :shovel-flute]
   [item :net]
   [item :book]
   [item :bottle]
   [item :somaria]
   [item :byrna]
   [item :cape]
   [item :mirror]])