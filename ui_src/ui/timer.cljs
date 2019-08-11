(ns ui.timer
  (:require [reagent.core :as reagent :refer [atom]]))

(def timer-resolution-ms 10)

(defn game-timer []
  (let [ms-elapsed (atom 0)
        interval-id (atom nil)
        reset-interval #(do (js/clearInterval @interval-id) (reset! interval-id nil))]
    (fn []
      [:div
       [:span
        {:on-click (fn []
                     (if (nil? @interval-id)
                       (reset! interval-id (js/setInterval #(swap! ms-elapsed inc) timer-resolution-ms))
                       (reset-interval)))
         :on-context-menu #(do (reset! ms-elapsed 0) (reset-interval))}
        @ms-elapsed]
       ])))