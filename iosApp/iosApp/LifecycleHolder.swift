//
//  LifecycleHolder.swift
//  iosApp
//
//  Created by NHN on 2/17/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import shared

class LifecycleHolder : ObservableObject {
    let lifecycle: LifecycleRegistry
    
    init() {
        lifecycle = LifecycleRegistryKt.LifecycleRegistry()
        
        lifecycle.onCreate()
    }
    
    deinit {
        lifecycle.onDestroy()
    }
}
