/*
 * This file is part of Mixin, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.asm.service;

/**
 * Audit trail is responsible for logging activities during mixin application to
 * target classes for use as debugging information later on. An audit trail
 * service can either log audit entries internally for retrieval on crash, or
 * can delegate to an underlying subsystem which handles this behaviour.
 * 
 * <p>This service component is entirely optional and services can elect to
 * return <tt>null</tt> if the platform does not support this functionality.</p>
 */
public interface IMixinAuditTrail {
    
    /**
     * Called when a class has a mixin applied to it by mixin.
     * 
     * @param className Target class name
     * @param mixinName Mixin name
     */
    public abstract void onApply(String className, String mixinName);

    /**
     * Called when a class is post-processed by mixin. This is the case for
     * synthetic inner classes (eg. switch table) and for accessor interfaces.
     * 
     * @param className Class being post-processed
     */
    public abstract void onPostProcess(String className);

}
