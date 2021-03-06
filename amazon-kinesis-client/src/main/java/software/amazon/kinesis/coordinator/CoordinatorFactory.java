/*
 *  Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 *  Licensed under the Amazon Software License (the "License").
 *  You may not use this file except in compliance with the License.
 *  A copy of the License is located at
 *
 *  http://aws.amazon.com/asl/
 *
 *  or in the "license" file accompanying this file. This file is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 *  express or implied. See the License for the specific language governing
 *  permissions and limitations under the License.
 */

package software.amazon.kinesis.coordinator;

import java.util.concurrent.ExecutorService;

import software.amazon.kinesis.checkpoint.ShardRecordProcessorCheckpointer;
import software.amazon.kinesis.leases.ShardInfo;
import software.amazon.kinesis.processor.Checkpointer;

/**
 *
 */
public interface CoordinatorFactory {
    /**
     * Creates the executor service to be used by the Scheduler.
     *
     * @return ExecutorService
     */
    ExecutorService createExecutorService();

    /**
     * Creates GracefulShutdownCoordinator to be used by the Scheduler.
     *
     * <p>
     *     Note: This method has been deprecated, and will be removed in a future release. Use the configuration in
     *     {@link CoordinatorConfig#gracefulShutdownCoordinator}. Set the
     *     {@link CoordinatorConfig#gracefulShutdownCoordinator} to null in order to use this method.
     * </p>
     *
     * @return GracefulShutdownCoordinator
     */
    @Deprecated
    GracefulShutdownCoordinator createGracefulShutdownCoordinator();

    /**
     * Creates a WorkerStateChangeListener to be used by the Scheduler.
     *
     * <p>
     *     Note: This method has been deprecated, and will be removed in a future release. Use the configuration in
     *     {@link CoordinatorConfig#workerStateChangeListener}. Set the
     *     {@link CoordinatorConfig#workerStateChangeListener} to null in order to use this method.
     * </p>
     *
     * @return
     */
    @Deprecated
    WorkerStateChangeListener createWorkerStateChangeListener();

    /**
     * Creates a RecordProcessorChedckpointer to be used by the Scheduler.
     *
     * @param shardInfo ShardInfo to be used in order to create the ShardRecordProcessorCheckpointer
     * @param checkpoint Checkpointer to be used in order to create Shardthe RecordProcessorCheckpointer
     * @return ShardRecordProcessorCheckpointer
     */
    ShardRecordProcessorCheckpointer createRecordProcessorCheckpointer(ShardInfo shardInfo, Checkpointer checkpoint);
}
