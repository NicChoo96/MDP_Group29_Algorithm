package pathserver;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: pathserver.proto")
public final class PathServerGrpc {

  private PathServerGrpc() {}

  public static final String SERVICE_NAME = "pathserver.PathServer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<pathserver.Pathserver.PlanRequest,
      pathserver.Pathserver.PlanReply> getPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Plan",
      requestType = pathserver.Pathserver.PlanRequest.class,
      responseType = pathserver.Pathserver.PlanReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pathserver.Pathserver.PlanRequest,
      pathserver.Pathserver.PlanReply> getPlanMethod() {
    io.grpc.MethodDescriptor<pathserver.Pathserver.PlanRequest, pathserver.Pathserver.PlanReply> getPlanMethod;
    if ((getPlanMethod = PathServerGrpc.getPlanMethod) == null) {
      synchronized (PathServerGrpc.class) {
        if ((getPlanMethod = PathServerGrpc.getPlanMethod) == null) {
          PathServerGrpc.getPlanMethod = getPlanMethod = 
              io.grpc.MethodDescriptor.<pathserver.Pathserver.PlanRequest, pathserver.Pathserver.PlanReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "pathserver.PathServer", "Plan"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pathserver.Pathserver.PlanRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pathserver.Pathserver.PlanReply.getDefaultInstance()))
                  .setSchemaDescriptor(new PathServerMethodDescriptorSupplier("Plan"))
                  .build();
          }
        }
     }
     return getPlanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pathserver.Pathserver.State,
      com.google.protobuf.BoolValue> getIsValidMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "IsValid",
      requestType = pathserver.Pathserver.State.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pathserver.Pathserver.State,
      com.google.protobuf.BoolValue> getIsValidMethod() {
    io.grpc.MethodDescriptor<pathserver.Pathserver.State, com.google.protobuf.BoolValue> getIsValidMethod;
    if ((getIsValidMethod = PathServerGrpc.getIsValidMethod) == null) {
      synchronized (PathServerGrpc.class) {
        if ((getIsValidMethod = PathServerGrpc.getIsValidMethod) == null) {
          PathServerGrpc.getIsValidMethod = getIsValidMethod = 
              io.grpc.MethodDescriptor.<pathserver.Pathserver.State, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "pathserver.PathServer", "IsValid"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pathserver.Pathserver.State.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
                  .setSchemaDescriptor(new PathServerMethodDescriptorSupplier("IsValid"))
                  .build();
          }
        }
     }
     return getIsValidMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PathServerStub newStub(io.grpc.Channel channel) {
    return new PathServerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PathServerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PathServerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PathServerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PathServerFutureStub(channel);
  }

  /**
   */
  public static abstract class PathServerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     **
     * Plan a new path.
     * Fails if the start and / or end state are invalid.
     * Fails if no path could be found.
     * </pre>
     */
    public void plan(pathserver.Pathserver.PlanRequest request,
        io.grpc.stub.StreamObserver<pathserver.Pathserver.PlanReply> responseObserver) {
      asyncUnimplementedUnaryCall(getPlanMethod(), responseObserver);
    }

    /**
     * <pre>
     **
     * Checks if a given state is valid.
     * </pre>
     */
    public void isValid(pathserver.Pathserver.State request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnimplementedUnaryCall(getIsValidMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPlanMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                pathserver.Pathserver.PlanRequest,
                pathserver.Pathserver.PlanReply>(
                  this, METHODID_PLAN)))
          .addMethod(
            getIsValidMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                pathserver.Pathserver.State,
                com.google.protobuf.BoolValue>(
                  this, METHODID_IS_VALID)))
          .build();
    }
  }

  /**
   */
  public static final class PathServerStub extends io.grpc.stub.AbstractStub<PathServerStub> {
    private PathServerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PathServerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PathServerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PathServerStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Plan a new path.
     * Fails if the start and / or end state are invalid.
     * Fails if no path could be found.
     * </pre>
     */
    public void plan(pathserver.Pathserver.PlanRequest request,
        io.grpc.stub.StreamObserver<pathserver.Pathserver.PlanReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPlanMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     **
     * Checks if a given state is valid.
     * </pre>
     */
    public void isValid(pathserver.Pathserver.State request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getIsValidMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PathServerBlockingStub extends io.grpc.stub.AbstractStub<PathServerBlockingStub> {
    private PathServerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PathServerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PathServerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PathServerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Plan a new path.
     * Fails if the start and / or end state are invalid.
     * Fails if no path could be found.
     * </pre>
     */
    public pathserver.Pathserver.PlanReply plan(pathserver.Pathserver.PlanRequest request) {
      return blockingUnaryCall(
          getChannel(), getPlanMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * Checks if a given state is valid.
     * </pre>
     */
    public com.google.protobuf.BoolValue isValid(pathserver.Pathserver.State request) {
      return blockingUnaryCall(
          getChannel(), getIsValidMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PathServerFutureStub extends io.grpc.stub.AbstractStub<PathServerFutureStub> {
    private PathServerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PathServerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PathServerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PathServerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Plan a new path.
     * Fails if the start and / or end state are invalid.
     * Fails if no path could be found.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<pathserver.Pathserver.PlanReply> plan(
        pathserver.Pathserver.PlanRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPlanMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     **
     * Checks if a given state is valid.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> isValid(
        pathserver.Pathserver.State request) {
      return futureUnaryCall(
          getChannel().newCall(getIsValidMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PLAN = 0;
  private static final int METHODID_IS_VALID = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PathServerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PathServerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PLAN:
          serviceImpl.plan((pathserver.Pathserver.PlanRequest) request,
              (io.grpc.stub.StreamObserver<pathserver.Pathserver.PlanReply>) responseObserver);
          break;
        case METHODID_IS_VALID:
          serviceImpl.isValid((pathserver.Pathserver.State) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PathServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PathServerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return pathserver.Pathserver.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PathServer");
    }
  }

  private static final class PathServerFileDescriptorSupplier
      extends PathServerBaseDescriptorSupplier {
    PathServerFileDescriptorSupplier() {}
  }

  private static final class PathServerMethodDescriptorSupplier
      extends PathServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PathServerMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PathServerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PathServerFileDescriptorSupplier())
              .addMethod(getPlanMethod())
              .addMethod(getIsValidMethod())
              .build();
        }
      }
    }
    return result;
  }
}
