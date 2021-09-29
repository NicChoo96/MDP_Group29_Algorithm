package com.mdp.grpc;

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
    comments = "Source: algocomm.proto")
public final class algoGrpc {

  private algoGrpc() {}

  public static final String SERVICE_NAME = "algo.algo";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.mdp.grpc.Empty,
      com.mdp.grpc.ObstacleString> getReceiveCoordinatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReceiveCoordinates",
      requestType = com.mdp.grpc.Empty.class,
      responseType = com.mdp.grpc.ObstacleString.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mdp.grpc.Empty,
      com.mdp.grpc.ObstacleString> getReceiveCoordinatesMethod() {
    io.grpc.MethodDescriptor<com.mdp.grpc.Empty, com.mdp.grpc.ObstacleString> getReceiveCoordinatesMethod;
    if ((getReceiveCoordinatesMethod = algoGrpc.getReceiveCoordinatesMethod) == null) {
      synchronized (algoGrpc.class) {
        if ((getReceiveCoordinatesMethod = algoGrpc.getReceiveCoordinatesMethod) == null) {
          algoGrpc.getReceiveCoordinatesMethod = getReceiveCoordinatesMethod = 
              io.grpc.MethodDescriptor.<com.mdp.grpc.Empty, com.mdp.grpc.ObstacleString>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "algo.algo", "ReceiveCoordinates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mdp.grpc.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mdp.grpc.ObstacleString.getDefaultInstance()))
                  .setSchemaDescriptor(new algoMethodDescriptorSupplier("ReceiveCoordinates"))
                  .build();
          }
        }
     }
     return getReceiveCoordinatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mdp.grpc.MoveRequest,
      com.mdp.grpc.MoveResponse> getMoveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Move",
      requestType = com.mdp.grpc.MoveRequest.class,
      responseType = com.mdp.grpc.MoveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mdp.grpc.MoveRequest,
      com.mdp.grpc.MoveResponse> getMoveMethod() {
    io.grpc.MethodDescriptor<com.mdp.grpc.MoveRequest, com.mdp.grpc.MoveResponse> getMoveMethod;
    if ((getMoveMethod = algoGrpc.getMoveMethod) == null) {
      synchronized (algoGrpc.class) {
        if ((getMoveMethod = algoGrpc.getMoveMethod) == null) {
          algoGrpc.getMoveMethod = getMoveMethod = 
              io.grpc.MethodDescriptor.<com.mdp.grpc.MoveRequest, com.mdp.grpc.MoveResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "algo.algo", "Move"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mdp.grpc.MoveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mdp.grpc.MoveResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new algoMethodDescriptorSupplier("Move"))
                  .build();
          }
        }
     }
     return getMoveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mdp.grpc.Empty,
      com.mdp.grpc.RadiiResponse> getGetRadiiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRadii",
      requestType = com.mdp.grpc.Empty.class,
      responseType = com.mdp.grpc.RadiiResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mdp.grpc.Empty,
      com.mdp.grpc.RadiiResponse> getGetRadiiMethod() {
    io.grpc.MethodDescriptor<com.mdp.grpc.Empty, com.mdp.grpc.RadiiResponse> getGetRadiiMethod;
    if ((getGetRadiiMethod = algoGrpc.getGetRadiiMethod) == null) {
      synchronized (algoGrpc.class) {
        if ((getGetRadiiMethod = algoGrpc.getGetRadiiMethod) == null) {
          algoGrpc.getGetRadiiMethod = getGetRadiiMethod = 
              io.grpc.MethodDescriptor.<com.mdp.grpc.Empty, com.mdp.grpc.RadiiResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "algo.algo", "GetRadii"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mdp.grpc.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mdp.grpc.RadiiResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new algoMethodDescriptorSupplier("GetRadii"))
                  .build();
          }
        }
     }
     return getGetRadiiMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mdp.grpc.RobotPosition,
      com.mdp.grpc.Empty> getMoveVirtualMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MoveVirtual",
      requestType = com.mdp.grpc.RobotPosition.class,
      responseType = com.mdp.grpc.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mdp.grpc.RobotPosition,
      com.mdp.grpc.Empty> getMoveVirtualMethod() {
    io.grpc.MethodDescriptor<com.mdp.grpc.RobotPosition, com.mdp.grpc.Empty> getMoveVirtualMethod;
    if ((getMoveVirtualMethod = algoGrpc.getMoveVirtualMethod) == null) {
      synchronized (algoGrpc.class) {
        if ((getMoveVirtualMethod = algoGrpc.getMoveVirtualMethod) == null) {
          algoGrpc.getMoveVirtualMethod = getMoveVirtualMethod = 
              io.grpc.MethodDescriptor.<com.mdp.grpc.RobotPosition, com.mdp.grpc.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "algo.algo", "MoveVirtual"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mdp.grpc.RobotPosition.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mdp.grpc.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new algoMethodDescriptorSupplier("MoveVirtual"))
                  .build();
          }
        }
     }
     return getMoveVirtualMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mdp.grpc.ImageID,
      com.mdp.grpc.Empty> getTakePictureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TakePicture",
      requestType = com.mdp.grpc.ImageID.class,
      responseType = com.mdp.grpc.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mdp.grpc.ImageID,
      com.mdp.grpc.Empty> getTakePictureMethod() {
    io.grpc.MethodDescriptor<com.mdp.grpc.ImageID, com.mdp.grpc.Empty> getTakePictureMethod;
    if ((getTakePictureMethod = algoGrpc.getTakePictureMethod) == null) {
      synchronized (algoGrpc.class) {
        if ((getTakePictureMethod = algoGrpc.getTakePictureMethod) == null) {
          algoGrpc.getTakePictureMethod = getTakePictureMethod = 
              io.grpc.MethodDescriptor.<com.mdp.grpc.ImageID, com.mdp.grpc.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "algo.algo", "TakePicture"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mdp.grpc.ImageID.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mdp.grpc.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new algoMethodDescriptorSupplier("TakePicture"))
                  .build();
          }
        }
     }
     return getTakePictureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mdp.grpc.StatusString,
      com.mdp.grpc.Empty> getUpdateStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateStatus",
      requestType = com.mdp.grpc.StatusString.class,
      responseType = com.mdp.grpc.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mdp.grpc.StatusString,
      com.mdp.grpc.Empty> getUpdateStatusMethod() {
    io.grpc.MethodDescriptor<com.mdp.grpc.StatusString, com.mdp.grpc.Empty> getUpdateStatusMethod;
    if ((getUpdateStatusMethod = algoGrpc.getUpdateStatusMethod) == null) {
      synchronized (algoGrpc.class) {
        if ((getUpdateStatusMethod = algoGrpc.getUpdateStatusMethod) == null) {
          algoGrpc.getUpdateStatusMethod = getUpdateStatusMethod = 
              io.grpc.MethodDescriptor.<com.mdp.grpc.StatusString, com.mdp.grpc.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "algo.algo", "UpdateStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mdp.grpc.StatusString.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mdp.grpc.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new algoMethodDescriptorSupplier("UpdateStatus"))
                  .build();
          }
        }
     }
     return getUpdateStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mdp.grpc.Empty,
      com.mdp.grpc.StartResponse> getCheckStartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckStart",
      requestType = com.mdp.grpc.Empty.class,
      responseType = com.mdp.grpc.StartResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mdp.grpc.Empty,
      com.mdp.grpc.StartResponse> getCheckStartMethod() {
    io.grpc.MethodDescriptor<com.mdp.grpc.Empty, com.mdp.grpc.StartResponse> getCheckStartMethod;
    if ((getCheckStartMethod = algoGrpc.getCheckStartMethod) == null) {
      synchronized (algoGrpc.class) {
        if ((getCheckStartMethod = algoGrpc.getCheckStartMethod) == null) {
          algoGrpc.getCheckStartMethod = getCheckStartMethod = 
              io.grpc.MethodDescriptor.<com.mdp.grpc.Empty, com.mdp.grpc.StartResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "algo.algo", "CheckStart"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mdp.grpc.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mdp.grpc.StartResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new algoMethodDescriptorSupplier("CheckStart"))
                  .build();
          }
        }
     }
     return getCheckStartMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static algoStub newStub(io.grpc.Channel channel) {
    return new algoStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static algoBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new algoBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static algoFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new algoFutureStub(channel);
  }

  /**
   */
  public static abstract class algoImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Client (algo) receives obstacle information from server (rPi).
     * </pre>
     */
    public void receiveCoordinates(com.mdp.grpc.Empty request,
        io.grpc.stub.StreamObserver<com.mdp.grpc.ObstacleString> responseObserver) {
      asyncUnimplementedUnaryCall(getReceiveCoordinatesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Commands the robot to move.
     * </pre>
     */
    public void move(com.mdp.grpc.MoveRequest request,
        io.grpc.stub.StreamObserver<com.mdp.grpc.MoveResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getMoveMethod(), responseObserver);
    }

    /**
     * <pre>
     * Obtain a list of available turn radii.
     * </pre>
     */
    public void getRadii(com.mdp.grpc.Empty request,
        io.grpc.stub.StreamObserver<com.mdp.grpc.RadiiResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRadiiMethod(), responseObserver);
    }

    /**
     * <pre>
     * Client (algo) sends the coordinates of the robot to the server (rPi).
     * </pre>
     */
    public void moveVirtual(com.mdp.grpc.RobotPosition request,
        io.grpc.stub.StreamObserver<com.mdp.grpc.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getMoveVirtualMethod(), responseObserver);
    }

    /**
     * <pre>
     * Client sends a request to take picture
     * </pre>
     */
    public void takePicture(com.mdp.grpc.ImageID request,
        io.grpc.stub.StreamObserver<com.mdp.grpc.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getTakePictureMethod(), responseObserver);
    }

    /**
     * <pre>
     * Client updates the current status
     * </pre>
     */
    public void updateStatus(com.mdp.grpc.StatusString request,
        io.grpc.stub.StreamObserver<com.mdp.grpc.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * Check if the Android has sent the start command
     * </pre>
     */
    public void checkStart(com.mdp.grpc.Empty request,
        io.grpc.stub.StreamObserver<com.mdp.grpc.StartResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckStartMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getReceiveCoordinatesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.mdp.grpc.Empty,
                com.mdp.grpc.ObstacleString>(
                  this, METHODID_RECEIVE_COORDINATES)))
          .addMethod(
            getMoveMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.mdp.grpc.MoveRequest,
                com.mdp.grpc.MoveResponse>(
                  this, METHODID_MOVE)))
          .addMethod(
            getGetRadiiMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.mdp.grpc.Empty,
                com.mdp.grpc.RadiiResponse>(
                  this, METHODID_GET_RADII)))
          .addMethod(
            getMoveVirtualMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.mdp.grpc.RobotPosition,
                com.mdp.grpc.Empty>(
                  this, METHODID_MOVE_VIRTUAL)))
          .addMethod(
            getTakePictureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.mdp.grpc.ImageID,
                com.mdp.grpc.Empty>(
                  this, METHODID_TAKE_PICTURE)))
          .addMethod(
            getUpdateStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.mdp.grpc.StatusString,
                com.mdp.grpc.Empty>(
                  this, METHODID_UPDATE_STATUS)))
          .addMethod(
            getCheckStartMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.mdp.grpc.Empty,
                com.mdp.grpc.StartResponse>(
                  this, METHODID_CHECK_START)))
          .build();
    }
  }

  /**
   */
  public static final class algoStub extends io.grpc.stub.AbstractStub<algoStub> {
    private algoStub(io.grpc.Channel channel) {
      super(channel);
    }

    private algoStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected algoStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new algoStub(channel, callOptions);
    }

    /**
     * <pre>
     * Client (algo) receives obstacle information from server (rPi).
     * </pre>
     */
    public void receiveCoordinates(com.mdp.grpc.Empty request,
        io.grpc.stub.StreamObserver<com.mdp.grpc.ObstacleString> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReceiveCoordinatesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Commands the robot to move.
     * </pre>
     */
    public void move(com.mdp.grpc.MoveRequest request,
        io.grpc.stub.StreamObserver<com.mdp.grpc.MoveResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMoveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Obtain a list of available turn radii.
     * </pre>
     */
    public void getRadii(com.mdp.grpc.Empty request,
        io.grpc.stub.StreamObserver<com.mdp.grpc.RadiiResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRadiiMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Client (algo) sends the coordinates of the robot to the server (rPi).
     * </pre>
     */
    public void moveVirtual(com.mdp.grpc.RobotPosition request,
        io.grpc.stub.StreamObserver<com.mdp.grpc.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMoveVirtualMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Client sends a request to take picture
     * </pre>
     */
    public void takePicture(com.mdp.grpc.ImageID request,
        io.grpc.stub.StreamObserver<com.mdp.grpc.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTakePictureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Client updates the current status
     * </pre>
     */
    public void updateStatus(com.mdp.grpc.StatusString request,
        io.grpc.stub.StreamObserver<com.mdp.grpc.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Check if the Android has sent the start command
     * </pre>
     */
    public void checkStart(com.mdp.grpc.Empty request,
        io.grpc.stub.StreamObserver<com.mdp.grpc.StartResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckStartMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class algoBlockingStub extends io.grpc.stub.AbstractStub<algoBlockingStub> {
    private algoBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private algoBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected algoBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new algoBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Client (algo) receives obstacle information from server (rPi).
     * </pre>
     */
    public com.mdp.grpc.ObstacleString receiveCoordinates(com.mdp.grpc.Empty request) {
      return blockingUnaryCall(
          getChannel(), getReceiveCoordinatesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Commands the robot to move.
     * </pre>
     */
    public com.mdp.grpc.MoveResponse move(com.mdp.grpc.MoveRequest request) {
      return blockingUnaryCall(
          getChannel(), getMoveMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Obtain a list of available turn radii.
     * </pre>
     */
    public com.mdp.grpc.RadiiResponse getRadii(com.mdp.grpc.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetRadiiMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Client (algo) sends the coordinates of the robot to the server (rPi).
     * </pre>
     */
    public com.mdp.grpc.Empty moveVirtual(com.mdp.grpc.RobotPosition request) {
      return blockingUnaryCall(
          getChannel(), getMoveVirtualMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Client sends a request to take picture
     * </pre>
     */
    public com.mdp.grpc.Empty takePicture(com.mdp.grpc.ImageID request) {
      return blockingUnaryCall(
          getChannel(), getTakePictureMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Client updates the current status
     * </pre>
     */
    public com.mdp.grpc.Empty updateStatus(com.mdp.grpc.StatusString request) {
      return blockingUnaryCall(
          getChannel(), getUpdateStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Check if the Android has sent the start command
     * </pre>
     */
    public com.mdp.grpc.StartResponse checkStart(com.mdp.grpc.Empty request) {
      return blockingUnaryCall(
          getChannel(), getCheckStartMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class algoFutureStub extends io.grpc.stub.AbstractStub<algoFutureStub> {
    private algoFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private algoFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected algoFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new algoFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Client (algo) receives obstacle information from server (rPi).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mdp.grpc.ObstacleString> receiveCoordinates(
        com.mdp.grpc.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getReceiveCoordinatesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Commands the robot to move.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mdp.grpc.MoveResponse> move(
        com.mdp.grpc.MoveRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMoveMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Obtain a list of available turn radii.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mdp.grpc.RadiiResponse> getRadii(
        com.mdp.grpc.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRadiiMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Client (algo) sends the coordinates of the robot to the server (rPi).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mdp.grpc.Empty> moveVirtual(
        com.mdp.grpc.RobotPosition request) {
      return futureUnaryCall(
          getChannel().newCall(getMoveVirtualMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Client sends a request to take picture
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mdp.grpc.Empty> takePicture(
        com.mdp.grpc.ImageID request) {
      return futureUnaryCall(
          getChannel().newCall(getTakePictureMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Client updates the current status
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mdp.grpc.Empty> updateStatus(
        com.mdp.grpc.StatusString request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateStatusMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Check if the Android has sent the start command
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mdp.grpc.StartResponse> checkStart(
        com.mdp.grpc.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckStartMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RECEIVE_COORDINATES = 0;
  private static final int METHODID_MOVE = 1;
  private static final int METHODID_GET_RADII = 2;
  private static final int METHODID_MOVE_VIRTUAL = 3;
  private static final int METHODID_TAKE_PICTURE = 4;
  private static final int METHODID_UPDATE_STATUS = 5;
  private static final int METHODID_CHECK_START = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final algoImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(algoImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RECEIVE_COORDINATES:
          serviceImpl.receiveCoordinates((com.mdp.grpc.Empty) request,
              (io.grpc.stub.StreamObserver<com.mdp.grpc.ObstacleString>) responseObserver);
          break;
        case METHODID_MOVE:
          serviceImpl.move((com.mdp.grpc.MoveRequest) request,
              (io.grpc.stub.StreamObserver<com.mdp.grpc.MoveResponse>) responseObserver);
          break;
        case METHODID_GET_RADII:
          serviceImpl.getRadii((com.mdp.grpc.Empty) request,
              (io.grpc.stub.StreamObserver<com.mdp.grpc.RadiiResponse>) responseObserver);
          break;
        case METHODID_MOVE_VIRTUAL:
          serviceImpl.moveVirtual((com.mdp.grpc.RobotPosition) request,
              (io.grpc.stub.StreamObserver<com.mdp.grpc.Empty>) responseObserver);
          break;
        case METHODID_TAKE_PICTURE:
          serviceImpl.takePicture((com.mdp.grpc.ImageID) request,
              (io.grpc.stub.StreamObserver<com.mdp.grpc.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_STATUS:
          serviceImpl.updateStatus((com.mdp.grpc.StatusString) request,
              (io.grpc.stub.StreamObserver<com.mdp.grpc.Empty>) responseObserver);
          break;
        case METHODID_CHECK_START:
          serviceImpl.checkStart((com.mdp.grpc.Empty) request,
              (io.grpc.stub.StreamObserver<com.mdp.grpc.StartResponse>) responseObserver);
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

  private static abstract class algoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    algoBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.mdp.grpc.Algocomm.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("algo");
    }
  }

  private static final class algoFileDescriptorSupplier
      extends algoBaseDescriptorSupplier {
    algoFileDescriptorSupplier() {}
  }

  private static final class algoMethodDescriptorSupplier
      extends algoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    algoMethodDescriptorSupplier(String methodName) {
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
      synchronized (algoGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new algoFileDescriptorSupplier())
              .addMethod(getReceiveCoordinatesMethod())
              .addMethod(getMoveMethod())
              .addMethod(getGetRadiiMethod())
              .addMethod(getMoveVirtualMethod())
              .addMethod(getTakePictureMethod())
              .addMethod(getUpdateStatusMethod())
              .addMethod(getCheckStartMethod())
              .build();
        }
      }
    }
    return result;
  }
}
