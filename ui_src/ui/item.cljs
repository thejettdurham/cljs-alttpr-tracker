(ns ui.item
  (:require [ui.state.items :as item-state]))

(defn item [key]
  (let [state (key @item-state/items)]
   [:img {:src             (str "img/items/" (name key) state ".png")
          :class           (if (= state 0) "disabled" "")
          :on-click        #(item-state/increment-item-status key)
          :on-context-menu #(item-state/decrement-item-status key)}]))